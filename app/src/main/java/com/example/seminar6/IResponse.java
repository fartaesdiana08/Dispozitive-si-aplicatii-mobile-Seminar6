package com.example.seminar6;

import java.util.List;

public interface IResponse {
    public void onSuccess(List<Oras> list);
    public void onError(String errorMessage);
}
