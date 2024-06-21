package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum BCryptVersion {
	
    $2A("$2a"),
    $2Y("$2y"),
    $2B("$2b");

    private final String version;

    BCryptVersion(String version) {
        this.version = version;
    }

}
