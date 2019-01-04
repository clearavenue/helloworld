//Terraform Role
resource "aws_iam_role" "terraformrole" {
  name = "terraform-role"
  assume_role_policy = "${data.aws_iam_policy_document.terraform-policy-assume-roles.json}"
}

data "aws_iam_policy_document" "terraform-policy-assume-roles"{
  statement {
    effect = "Allow"
    principals {
      identifiers = [
        "codepipeline.amazonaws.com",
        "codebuild.amazonaws.com",
        "codedeploy.amazonaws.com",
        "elasticbeanstalk.amazonaws.com",
        "ec2.amazonaws.com",
        "s3.amazonaws.com"
      ]
      type = "Service"
    }
    actions = ["sts:AssumeRole"]
  }
}

data "aws_iam_policy_document" "terraform_policy_document_2" {
  statement {
    resources = ["*"]
    actions = [
      "elasticbeanstalk:CreateApplicationVersion",
      "elasticbeanstalk:UpdateEnvironment",
      "codedeploy:GetApplication",
      "codedeploy:GetDeploymentGroup",
      "codedeploy:ListApplications",
      "codedeploy:ListDeploymentGroups",
      "elasticbeanstalk:DescribeApplications",
      "elasticbeanstalk:DescribeEnvironments",
      "autoscaling:SuspendProcesses",
      "ecr:*",
      "ec2:*",
      "elastictbeanstalk:*",
      "ecs:*",
      "ecr:*",
      "elasticloadbalancing:*",
      "cloudwatch:*",
      "autosclaing:*",
      "codepipeline:*",
      "s3:*",
      "codebuild:CreateProject",
      "codebuild:DeleteProjects",
      "codebuild:BatchGetBuilds",
      "codebuild:StartBuild",
      "cloudformation:*",
      "logs:*",
      "kms:*",
      "iam:*",
      "ecr:GetAuthorizationToken",
      "autoscaling:DescribeAutoScalingGroups"
    ]
  }
}
resource "aws_iam_role_policy" "terraform_policy" {
  policy = "${data.aws_iam_policy_document.terraform_policy_document_2.json}"
  role = "${aws_iam_role.terraformrole.id}"
}

//resource "aws_iam_policy" "ecr_policy" {
//  policy = <<EOF
//{
//  "Version": "2012-10-17",
//  "Statement": [
//    {
//      "Effect": "Allow",
//      "Resource": "*",
//      "Action": [
//        "ecr:*"
//      ]
//    }
//  ]
//}
//EOF
//}

//resource "aws_iam_policy" "auth_policy" {
//  policy = <<EOF
//{
//  "Version": "2012-10-17",
//  "Statement": [
//    {
//      "Effect": "Allow", "Resource": "*", "Action": ["ecr:GetAuthorizationToken"]
//    }
//  ]
//}
//EOF
//}

//data "aws_iam_policy" "beanstalk_policy"{
//  arn = "arn:aws:iam::aws:policy/AWSElasticBeanstalkFullAccess"
//}

//data "aws_iam_policy" "ec2_policy" {
//  arn = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryFullAccess"
//}
//
//data "aws_iam_policy" "codepipeline_policy" {
//  arn = "arn:aws:iam::aws:policy/AWSCodePipelineFullAccess"
//}
//
//data "aws_iam_policy" "s3_policy" {
//  arn = "arn:aws:iam::aws:policy/AmazonS3FullAccess"
//}
//
//data "aws_iam_policy" "codebuild_policy" {
//  arn = "arn:aws:iam::aws:policy/AWSCodeBuildAdminAccess"
//}
//
//data "aws_iam_policy" "cloudwatch_policy" {
//  arn = "arn:aws:iam::aws:policy/CloudWatchFullAccess"
//}
//
//resource "aws_iam_role_policy_attachment" "ec2_attachement" {
//  policy_arn = "${data.aws_iam_policy.ec2_policy.arn}"
//  role = "${aws_iam_role.terraformrole.name}"
//}

//resource "aws_iam_role_policy_attachment" "beanstalk_attachment" {
//  policy_arn = "${data.aws_iam_policy.beanstalk_policy.arn}"
//  role = "${aws_iam_role.terraformrole.name}"
//}

//resource "aws_iam_role_policy_attachment" "auth_attachment" {
//  policy_arn = "${aws_iam_policy.auth_policy.arn}"
//  role = "${aws_iam_role.terraformrole.name}"
//}

//resource "aws_iam_role_policy_attachment" "ecs_attachment" {
//  policy_arn = "${aws_iam_policy.ecr_policy.arn}"
//  role = "${aws_iam_role.terraformrole.name}"
//}

//resource "aws_iam_role_policy_attachment" "pipeline_access_attachment" {
//  role = "${aws_iam_role.terraformrole.name}"
//  policy_arn = "${data.aws_iam_policy.codepipeline_policy.arn}"
//}
//
//resource "aws_iam_role_policy_attachment" "s3_access_attachment" {
//  role = "${aws_iam_role.terraformrole.name}"
//  policy_arn = "${data.aws_iam_policy.s3_policy.arn}"
//}
//
//resource "aws_iam_role_policy_attachment" "codebuild_access_attachment" {
//  role = "${aws_iam_role.terraformrole.name}"
//  policy_arn = "${data.aws_iam_policy.codebuild_policy.arn}"
//}
//resource "aws_iam_role_policy_attachment" "cloudwatch_access_attachement" {
//  role = "${aws_iam_role.terraformrole.name}"
//  policy_arn = "${data.aws_iam_policy.cloudwatch_policy.arn}"
//}
resource "aws_iam_role_policy_attachment" "admin" {
  policy_arn = "arn:aws:iam::aws:policy/AdministratorAccess"
  role = "${aws_iam_role.terraformrole.name}"
}

//ECR Role & Policies

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
resource "aws_iam_role_policy_attachment" "ecs_attachment_ecr" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryReadOnly"
  role = "${aws_iam_role.ECR-ReadAccess.name}"
}
