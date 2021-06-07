package com.project.devWeek.exceptions;

import com.project.devWeek.util.MessageUtils;

public class NotFoundException extends RuntimeException {
    public NotFoundException (){
        super(MessageUtils.NO_RECORDS_FOUND);
    }

}
