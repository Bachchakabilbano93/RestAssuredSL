package com.RestAssured.reqrespojos;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ResponseData {

@SerializedName("data")
@Expose
private List<UserInfo> data;

public List<UserInfo> getData() {
return data;
}

public void setData(List<UserInfo> data) {
this.data = data;
}

}
