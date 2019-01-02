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
  }

  "source" {
    type = "CODEPIPELINE"
    location = "${aws_s3_bucket.helloworldbucket.bucket}"
  }
}