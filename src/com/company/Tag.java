package com.company;

import com.company.annotations.TagName;

@TagName("tags")
public class Tag {
    public String tag;

    public Tag(String tag) {
        this.tag = tag;
    }
}
