package org.occam.infra.executor.beans;

public class ResultBean {
    private String url;
    private Object returnInstance;

    public ResultBean(String url, Object returnInstance) {
        this.url = url;
        this.returnInstance = returnInstance;
    }

    public String getUrl() {
        return url;
    }

    public Object getReturnInstance() {
        return this.returnInstance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResultBean other = (ResultBean) obj;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("ResultBean [url=%s, returnInstance=%s]", url,
                returnInstance);
    }
}
