package by.htp3.hotel.service.exeption;

public class ServiceShowAllRoomsException extends ServiceException {
	
	private static final long serialVersionUID = 1L;

	public ServiceShowAllRoomsException(String message) {
		super(message);
	}

	public ServiceShowAllRoomsException(String message, Exception e) {
		super(message, e);
	}
}