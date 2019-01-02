resource "aws_codebuild_project" "helloworld_codebuild" {
  name = "helloworld"
  service_role = "${aws_iam_role.helloworldrole.arn}"
  "artifacts" {
    type = "CODEPIPELINE"
  }
  "cache" {
    type = "S3"
    location = "${aws_s3_bucket.helloworldbucket.bucket}"
  }

  "environment" {
    compute_type = "BUILD_GENERAL1_MEDIUM"
    image = "aws/codebuild/docker:18.09.0"
    type = "LINUX_CONTAINER"
    privileged_mode = true

    environment_variable {
      name = "AWS_DEFAULT_REGION"
      value = "us-east-1"
    }
    environment_variable {
      name = "IMAGE_REPO_NAME"
      value = "helloworld_ecr"
    }
    environment_variable {
      name = "IMAGE_TAG"
      value = "latest"
    }
    environment_variable {
      name = "AWS_ACCOUNT_ID"
      value = "288524100095"
    }
  }

  "source" {
    type = "CODEPIPELINE"
    location = "${aws_s3_bucket.helloworldbucket.bucket}"
  }
}