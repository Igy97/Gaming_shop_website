package com.gamingshop.service;

import com.gamingshop.domain.Payment;
import com.gamingshop.domain.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
