# Variables

variable "app_name" {
  description = "AppName is used as a prefix for uniquness"
  default = "HelloWorld"
}

variable "aws_region" {
  description = "Region for AWS Provider to use"
  default = "us-east-1"
}

variable "aws_account_id" {
  description = "AWS Account Id"
}

//variable "aws_access_key" {
//  description = "AWS Access Key"
//}
//variable "aws_secret_key" {
//  description = "AWS Secret Key"
//}

variable "git_owner" {
  description = "The Git Repository Owner"
}
variable "git_repo" {
  description = "The Git Repository Name"
}

variable "git_branch" {
  description = "The Git Repository Branch to pull from"
}

variable "git_oauth_token" {
  description = "The Git OAuth Token"
}
