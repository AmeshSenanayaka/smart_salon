package com.smart_salon.util;

import lombok.Getter;
import lombok.Setter;

/**
 * ==============================================================
 *  Author :Amesh Senanayaka
 *  Date : 03/18/2023 - 7:05 PM
 *  Description :A Common response with payload/status used as return results
 *               of Controller/Service methods
 * ==============================================================
 **/

@Getter
@Setter
public class CommonResponse {

    private Object payload = null;
    private String messages = "";
    private boolean status = false;

}
