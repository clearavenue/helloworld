data "aws_kms_alias" "s3kmskey" {
  name = "alias/helloworldKMSKey"
}

resource "aws_s3_bucket" "helloworldbucket"{
  bucket = "clearavenue-helloworld-bucket"

  server_side_encryption_configuration {
    "rule" {
      "apply_server_side_encryption_by_default" {
        sse_algorithm = "aws:kms"
        kms_master_key_id = "${data.aws_kms_alias.s3kmskey.arn}"
      }
    }
  }
}
