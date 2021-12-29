package com.nord.persistence.billing.interfaces;

import java.util.List;
import java.util.Map;

public interface IBilling {

  boolean addBillPayment(Map<String, Object> billDetails);

  List<IBillingModel> retrieveBillsForUser();

  boolean deleteBill(String payeeName);

  List<IBillingModel> retrieveAllBills();
}
