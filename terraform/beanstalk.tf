resource "aws_elastic_beanstalk_application" "helloworld" {
  name = "helloworld-beanstalk"
}

resource "aws_elastic_beanstalk_configuration_template" "beanstalk-template" {
  name = "helloworld-beanstalk-template"
  application = "${aws_elastic_beanstalk_application.helloworld.name}"
  solution_stack_name = "64bit Amazon Linux 2018.03 v2.12.6 running Docker 18.06.1-ce"
}

resource "aws_elastic_beanstalk_environment" "hw-dev-env" {
  name = "HelloWorld-Dev-Environment"
  application = "${aws_elastic_beanstalk_application.helloworld.name}"
  template_name = "${aws_elastic_beanstalk_configuration_template.beanstalk-template.name}"
}
resource "aws_elastic_beanstalk_environment" "hw-test-env" {
  name = "HelloWorld-Test-Environment"
  application = "${aws_elastic_beanstalk_application.helloworld.name}"
  template_name = "${aws_elastic_beanstalk_configuration_template.beanstalk-template.name}"
}
resource "aws_elastic_beanstalk_environment" "hw-prod-env" {
  name = "HelloWorld-Production-Environment"
  application = "${aws_elastic_beanstalk_application.helloworld.name}"
  template_name = "${aws_elastic_beanstalk_configuration_template.beanstalk-template.name}"
}