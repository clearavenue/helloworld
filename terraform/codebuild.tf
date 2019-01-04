
resource "aws_codebuild_project" "codebuild" {
  name = "${var.app_name}"
  service_role = "${aws_iam_role.terraformrole.arn}"
  depends_on = ["aws_iam_role.terraformrole", "aws_s3_bucket.bucket"]
  "artifacts" {
    type = "CODEPIPELINE"
  }
  "cache" {
    type = "S3"
    location = "${aws_s3_bucket.bucket.bucket}"
  }

  "environment" {
    compute_type = "BUILD_GENERAL1_MEDIUM"
    image = "aws/codebuild/docker:18.09.0"
    type = "LINUX_CONTAINER"
    privileged_mode = true

    environment_variable {
      name = "AWS_DEFAULT_REGION"
      value = "${var.aws_region}"
    }
    environment_variable {
      name = "IMAGE_REPO_NAME"
      value = "${var.app_name}_ecr"
    }
    environment_variable {
      name = "IMAGE_TAG"
      value = "latest"
    }
    environment_variable {
      name = "AWS_ACCOUNT_ID"
      value = "${var.aws_account_id}"
    }
  }

  "source" {
    type = "CODEPIPELINE"
    location = "${aws_s3_bucket.bucket.bucket}"
  }
}