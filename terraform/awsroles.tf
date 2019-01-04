
resource "aws_iam_role" "terraformrole" {
  name = "terraform-role"
  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Service": [
          "codepipeline.amazonaws.com",
          "codebuild.amazonaws.com",
          "codedeploy.amazonaws.com",
          "elasticbeanstalk.amazonaws.com",
          "ec2.amazonaws.com",
          "s3.amazonaws.com"
        ]
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
EOF
}

data "aws_iam_policy_document" "ecr-assume-role" {
  statement {
    principals {
      identifiers = ["ec2.amazonaws.com"]
      type = "Service"
    }
    actions = ["sts:AssumeRole"]
  }
}

resource "aws_iam_role" "ECR-ReadAccess" {
  name = "ECR-ReadAccess"
  assume_role_policy = "${data.aws_iam_policy_document.ecr-assume-role.json}"
}

resource "aws_iam_instance_profile" "beanstalk_ec2" {
  name = "beanstalk_ec2_profile"
  role = "${aws_iam_role.ECR-ReadAccess.name}"
}

resource "aws_iam_policy" "ecr_policy" {
  policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Resource": "*",
      "Action": [
        "ecr:*"
      ]
    }
  ]
}
EOF
}

resource "aws_iam_policy" "auth_policy" {
  policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow", "Resource": "*", "Action": ["ecr:GetAuthorizationToken"]
    }
  ]
}
EOF
}

data "aws_iam_policy" "beanstalk_policy"{
  arn = "arn:aws:iam::aws:policy/AWSElasticBeanstalkFullAccess"
}

data "aws_iam_policy" "ec2_policy" {
  arn = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryFullAccess"
}

data "aws_iam_policy" "codepipeline_policy" {
  arn = "arn:aws:iam::aws:policy/AWSCodePipelineFullAccess"
}

data "aws_iam_policy" "s3_policy" {
  arn = "arn:aws:iam::aws:policy/AmazonS3FullAccess"
}

data "aws_iam_policy" "codebuild_policy" {
  arn = "arn:aws:iam::aws:policy/AWSCodeBuildAdminAccess"
}

data "aws_iam_policy" "cloudwatch_policy" {
  arn = "arn:aws:iam::aws:policy/CloudWatchFullAccess"
}

resource "aws_iam_role_policy_attachment" "ec2_attachement" {
  policy_arn = "${data.aws_iam_policy.ec2_policy.arn}"
  role = "${aws_iam_role.terraformrole.name}"
}

resource "aws_iam_role_policy_attachment" "beanstalk_attachment" {
  policy_arn = "${data.aws_iam_policy.beanstalk_policy.arn}"
  role = "${aws_iam_role.terraformrole.name}"
}

resource "aws_iam_role_policy_attachment" "auth_attachment" {
  policy_arn = "${aws_iam_policy.auth_policy.arn}"
  role = "${aws_iam_role.terraformrole.name}"
}

resource "aws_iam_role_policy_attachment" "ecs_attachment" {
  policy_arn = "${aws_iam_policy.ecr_policy.arn}"
  role = "${aws_iam_role.terraformrole.name}"
}
resource "aws_iam_role_policy_attachment" "ecs_attachment_ecr" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryReadOnly"
  role = "${aws_iam_role.ECR-ReadAccess.name}"
}

resource "aws_iam_role_policy_attachment" "pipeline_access_attachment" {
  role = "${aws_iam_role.terraformrole.name}"
  policy_arn = "${data.aws_iam_policy.codepipeline_policy.arn}"
}

resource "aws_iam_role_policy_attachment" "s3_access_attachment" {
  role = "${aws_iam_role.terraformrole.name}"
  policy_arn = "${data.aws_iam_policy.s3_policy.arn}"
}

resource "aws_iam_role_policy_attachment" "codebuild_access_attachment" {
  role = "${aws_iam_role.terraformrole.name}"
  policy_arn = "${data.aws_iam_policy.codebuild_policy.arn}"
}
resource "aws_iam_role_policy_attachment" "cloudwatch_access_attachement" {
  role = "${aws_iam_role.terraformrole.name}"
  policy_arn = "${data.aws_iam_policy.cloudwatch_policy.arn}"
}
resource "aws_iam_role_policy_attachment" "admin" {
  policy_arn = "arn:aws:iam::aws:policy/AdministratorAccess"
  role = "${aws_iam_role.terraformrole.name}"
}