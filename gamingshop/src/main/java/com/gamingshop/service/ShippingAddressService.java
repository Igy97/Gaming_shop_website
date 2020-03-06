package com.gamingshop.service;

import com.gamingshop.domain.ShippingAddress;
import com.gamingshop.domain.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
