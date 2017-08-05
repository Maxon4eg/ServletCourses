package com.akhambir.servlet;

public class Request {

    private String uri;
    private String requestMethod;

    public Request(String uri, String requestMethod) {
        this.uri = uri;
        this.requestMethod = requestMethod;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (uri != null ? !uri.equals(request.uri) : request.uri != null) return false;
        return requestMethod != null ?
                requestMethod.equals(request.requestMethod) :
                request.requestMethod == null;
    }

    @Override
    public int hashCode() {
        int result = uri != null ? uri.hashCode() : 0;
        result = 31 * result + (requestMethod != null ? requestMethod.hashCode() : 0);
        return result;
    }
}
