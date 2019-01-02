resource "aws_codepipeline" "helloworld_pipeline" {
  "artifact_store" {
    location = "${aws_s3_bucket.helloworldbucket.bucket}"
    type = "S3"

    encryption_key {
      type = "KMS"
      id = "${data.aws_kms_alias.s3kmskey.arn}"
    }
  }
  name = "hellowworld_pipeline"
  role_arn = "${aws_iam_role.helloworldrole.arn}"
  "stage" {
    "action" {
      category = "Source"
      name = "Source"
      owner = "ThirdParty"
      provider = "GitHub"
      version = "1"
      output_artifacts = ["helloworld"]
      configuration {
        Owner = "clearavenue"
        Repo = "helloworld"
        Branch = "master"
        OAuthToken = "708fbcefb8d732a80d60cef1306070987c617cd0"
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
      input_artifacts = ["helloworld"]
      version = "1"
      configuration {
        ProjectName = "helloworld"
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
  target_pipeline = "${aws_codepipeline.helloworld_pipeline.name}"

  filter {
    json_path = "$.ref"
    match_equals = "refs/heads/{Branch}"
  }
}