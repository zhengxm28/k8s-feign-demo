package cn.k8s.feign.consumer.client.exception;

public class RemoteServiceException  extends RuntimeException {

	private static final long serialVersionUID = -5726933006363351176L;
	
	/**
	 * Constructor for RemoteServiceException.
	 * @param msg the detail message
	 */
	public RemoteServiceException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for RemoteServiceException.
	 * @param msg the detail message
	 * @param cause the root cause from the data access API in use
	 */
	public RemoteServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	/**
	 * Constructor for RemoteServiceException.
	 * @param msg the detail message
	 * @param cause the root cause from the data access API in use
	 */
	public RemoteServiceException(Throwable cause) {
		super(cause);
	}

}
