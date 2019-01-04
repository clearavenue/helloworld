resource "aws_elastic_beanstalk_application" "helloworld" {
  name = "${var.app_name}_beanstalk_application"
//  "appversion_lifecycle" {
//    service_role = "${aws_iam_role.terraformrole.arn}"
//  }
}

resource "aws_elastic_beanstalk_configuration_template" "beanstalk-template" {
  name = "${var.app_name}-beanstalk-template"
  application = "${aws_elastic_beanstalk_application.helloworld.name}"
  solution_stack_name = "64bit Amazon Linux 2018.03 v2.12.6 running Docker 18.06.1-ce"
}

resource "aws_elastic_beanstalk_environment" "dev-env" {
  name = "${var.app_name}-Dev-Environment"
  application = "${aws_elastic_beanstalk_application.helloworld.name}"
  template_name = "${aws_elastic_beanstalk_configuration_template.beanstalk-template.name}"

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name = "IamInstanceProfile"
    value = "${aws_iam_instance_profile.beanstalk_ec2.name}"
  }
}
//resource "aws_elastic_beanstalk_environment" "hw-test-env" {
//  name = "HelloWorld-Test-Environment"
//  application = "${aws_elastic_beanstalk_application.helloworld.name}"
//  template_name = "${aws_elastic_beanstalk_configuration_template.beanstalk-template.name}"
//}
//resource "aws_elastic_beanstalk_environment" "hw-prod-env" {
//  name = "HelloWorld-Production-Environment"
//  application = "${aws_elastic_beanstalk_application.helloworld.name}"
//  template_name = "${aws_elastic_beanstalk_configuration_template.beanstalk-template.name}"
//}
