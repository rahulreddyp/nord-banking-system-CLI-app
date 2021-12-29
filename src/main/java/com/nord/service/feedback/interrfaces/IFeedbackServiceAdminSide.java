package com.nord.service.feedback.interrfaces;

import com.nord.view.feedback.interfaces.IFeedbackAdminSideView;

public interface IFeedbackServiceAdminSide {

  /**
   * Shows the feedbacks on the admin side
   *
   * @param
   */
  void showFeedbacks();

  IFeedbackServiceAdminSide setView(IFeedbackAdminSideView feedbackAdminSideView);

  IFeedbackServiceAdminSide setFactory(IFeedbackFactory feedbackFactory);
}
