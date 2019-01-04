resource "aws_ecr_repository" "helloworld_ecr" {
  name = "${var.app_name}_ecr"
}

resource "aws_ecr_repository_policy" "ecr_policy" {
  repository = "${aws_ecr_repository.helloworld_ecr.name}"
  policy = <<EOF
{
  "Version": "2008-10-17",
  "Statement": [
    {
      "Sid": "new policy",
      "Effect": "Allow",
      "Principal": "*",
      "Action": [
        "ecr:*"
      ]
    }
  ]
}
EOF
}