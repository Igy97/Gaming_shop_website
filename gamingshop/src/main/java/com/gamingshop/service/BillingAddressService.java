package com.gamingshop.service;

import com.gamingshop.domain.BillingAddress;
import com.gamingshop.domain.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
