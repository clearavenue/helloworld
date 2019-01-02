
resource "aws_iam_role" "helloworldrole" {
  name = "helloworld-role"
  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Service": "codepipeline.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    },
    {
      "Effect": "Allow",
      "Principal": {
        "Service": "codebuild.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
EOF
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

resource "aws_iam_role_policy_attachment" "pipeline_access_attachment" {
  role = "${aws_iam_role.helloworldrole.name}"
  policy_arn = "${data.aws_iam_policy.codepipeline_policy.arn}"
}

resource "aws_iam_role_policy_attachment" "s3_access_attachment" {
  role = "${aws_iam_role.helloworldrole.name}"
  policy_arn = "${data.aws_iam_policy.s3_policy.arn}"
}

resource "aws_iam_role_policy_attachment" "codebuild_access_attachment" {
  role = "${aws_iam_role.helloworldrole.name}"
  policy_arn = "${data.aws_iam_policy.codebuild_policy.arn}"
}
resource "aws_iam_role_policy_attachment" "cloudwatch_access_attachement" {
  role = "${aws_iam_role.helloworldrole.name}"
  policy_arn = "${data.aws_iam_policy.cloudwatch_policy.arn}"
}