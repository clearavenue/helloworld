data "aws_kms_alias" "s3kmskey" {
  name = "alias/helloworldKMSKey"
}

#Encrpyt/Decrypt Key for S3 Bucket
resource "aws_kms_key" "s3_kms" {
  description = "S3 KMS Key"
}

resource "aws_iam_role" "s3_kms" {
  name = "iam_role_for_grant"
  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "sts:AssumeRole",
      "Principal": {
        "AWS": [
          "${aws_iam_role.terraformrole.arn}",
          "arn:aws:iam::288524100095:user/terraform",
          "arn:aws:iam::288524100095:user/portal"
        ]
      },
      "Effect": "Allow",
      "Sid": ""
    }
  ]
}
EOF
}

resource "aws_kms_grant" "s3_kms" {
  name = "${var.app_name}_s3_kms_grant"
  grantee_principal = "${aws_iam_role.s3_kms.arn}"
  key_id = "${aws_kms_key.s3_kms.key_id}"
  operations = ["Encrypt", "Decrypt", "GenerateDataKey", "CreateGrant", "DescribeKey", "ReEncryptFrom", "ReEncryptTo" ]
}

resource "aws_kms_alias" "s3_kms" {
  name = "alias/${var.app_name}_KMS_Key"
  target_key_id = "${aws_kms_key.s3_kms.key_id}"
}

resource "aws_s3_bucket" "bucket"{
  bucket = "${var.app_name}-${sha1("${var.app_name}-s3-bucket")}"
  force_destroy = true
  server_side_encryption_configuration {
    "rule" {
      "apply_server_side_encryption_by_default" {
        sse_algorithm = "aws:kms"
        kms_master_key_id = "${aws_kms_key.s3_kms.arn}"
      }
    }
  }
  lifecycle {
    ignore_changes = ["bucket"]
  }
}
