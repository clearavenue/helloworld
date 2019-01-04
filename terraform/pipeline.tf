resource "aws_codepipeline" "pipeline" {
  depends_on = ["aws_s3_bucket.bucket"]

  "artifact_store" {
    location = "${aws_s3_bucket.bucket.bucket}"
    type = "S3"

    encryption_key {
      type = "KMS"
      id = "${aws_kms_alias.s3_kms.arn}"
    }
  }
  name = "${var.app_name}_pipeline"
  role_arn = "${aws_iam_role.terraformrole.arn}"
  "stage" {
    "action" {
      category = "Source"
      name = "Source"
      owner = "ThirdParty"
      provider = "GitHub"
      version = "1"
      output_artifacts = ["${var.app_name}"]
      configuration {
        Owner = "${var.git_owner}"
        Repo = "${var.git_repo}"
        Branch = "${var.git_branch}"
        OAuthToken = "${var.git_oauth_token}"
      }
    }
    name = "Source"
  }

  "stage" {
    name = "Build"
    "action" {
      name = "Build"
      category = "Build"
      owner = "AWS"
      provider = "CodeBuild"
      input_artifacts = ["${var.app_name}"]
      output_artifacts = ["${var.app_name}-docker"]
      version = "1"
      configuration {
        ProjectName = "${var.app_name}"
      }
    }
  }

  "stage" {
    name = "Deploy"
    "action" {
      name = "Deploy"
      category = "Deploy"
      owner = "AWS"
      provider = "ElasticBeanstalk"
      version = "1"
      input_artifacts = ["${var.app_name}-docker"]
      configuration {
        ApplicationName = "${aws_elastic_beanstalk_application.helloworld.name}"
        EnvironmentName = "${aws_elastic_beanstalk_environment.dev-env.name}"
      }
    }
  }
}

locals {
  webhook_secret = "Super secret key"
}

resource "aws_codepipeline_webhook" "webhook" {
  name = "webhook"
  authentication = "UNAUTHENTICATED"
  target_action = "Source"
  target_pipeline = "${aws_codepipeline.pipeline.name}"

  filter {
    json_path = "$.ref"
    match_equals = "refs/heads/{Branch}"
  }
}