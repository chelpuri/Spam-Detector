package com.spamchecker.spamchecker.clientAdapter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    
    private boolean valid;

    private boolean block;

    private boolean disposable;

    private String domain;

    private String text;

    private String reason;

    private int risk;

    private String hostName;

    private String info;
    
    private String ip;
}
