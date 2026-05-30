package com.shirish.globalbookingsystem.service;

import com.shirish.globalbookingsystem.dto.request.parent.CreateParentRequest;
import com.shirish.globalbookingsystem.entity.Booking;
import com.shirish.globalbookingsystem.entity.Offering;
import com.shirish.globalbookingsystem.entity.Parent;

import java.util.List;

public interface ParentService {

    Parent createParent(CreateParentRequest request);

    List<Offering> getAvailableOfferings();

    List<Booking> getParentBookings(Long parentId);
}