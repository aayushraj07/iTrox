package com.example.commons.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

  public static final String SUCCESS = "Success";

  public static final String ERROR = "Error";

  public static final String API = "/api";

  public static final String V1 = "/v1";

  public static final String LMS = "/lms";

  public static final String IAM = "/iam";

  public static final String STORE = "/store";

  public static final String API_STORE_V1 = API + STORE + V1;

  public static final String API_IAM_V1 = API + IAM + V1;

  public static final String API_LMS_V1 = API + LMS + V1;

  public static final long EXPIRATION_TIME = 3600000;

  public static final String ANSWER_NOT_FOUND = "ANSWER_NOT_FOUND";
  public static final String MODULE_NOT_FOUND = "MODULE_NOT_FOUND";
  public static final String PROGRESS_NOT_FOUND = "PROGRESS_NOT_FOUND";
  public static final String CERTIFICATE_NOT_FOUND = "CERTIFICATE_NOT_FOUND";
  public static final String CATEGORY_NOT_FOUND = "CATEGORY_NOT_FOUND";

  public static final String PTS_TOPIC_NOT_FOUND = "PTS_TOPIC_NOT_FOUND";

  public static final String PTS_CHECKLIST_NOT_FOUND = "PTS_CHECKLIST_NOT_FOUND";
  public static final String ASSESSMENT_PRACTICAL_TOPIC_NOT_FOUND =
      "ASSESSMENT_PRACTICAL_TOPIC_NOT_FOUND";
  public static final String PTS_CHECKLIST_ALREADY_MAPPED_WITH_USER =
      "PTS_CHECKLIST_ALREADY_MAPPED_WITH_USER";
  public static final String ASSESSMENT_PRACTICAL_CHECKLIST_NOT_FOUND =
      "ASSESSMENT_PRACTICAL_CHECKLIST_NOT_FOUND";

  public static final String RATING_NOT_FOUND = "RATING_NOT_FOUND";
  public static final String FEEDBACK_NOT_FOUND = "FEEDBACK_NOT_FOUND";
  public static final String QUIZ_NOT_FOUND = "QUIZ_NOT_FOUND";

  public static final String QUESTION_NOT_FOUND = "QUESTION_NOT_FOUND";
  public static final String TOPIC_NOT_FOUND = "TOPIC_NOT_FOUND";
  public static final String VIDEO_NOT_FOUND = "VIDEO_NOT_FOUND";
  public static final String INVALID_STATE_OR_TYPE = "INVALID_STATE_OR_TYPE";
  public static final String SUB_TOPIC_NOT_FOUND = "SUB_TOPIC_NOT_FOUND";
  public static final String UNAUTHORIZED_ACCESS = "You are not authorized to access the resource";
  public static final String ACCESS_FORBIDDEN = "Access Forbidden";
  public static final String BAD_REQUEST = "Bad Request";
  public static final String RESOURCE_NOT_FOUND = "Requested resource not found";
  public static final String INTERNAL_SERVER_ERROR = "Something went wrong at server side";
  public static final Integer EXPIRY = 1000 * 60 * 60;
}
