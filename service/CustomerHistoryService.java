package service;

import pojo.CustomerHistory;

import java.util.List;

public interface CustomerHistoryService {
    CustomerHistory findCustomerHistory(String account);
}
