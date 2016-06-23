package by.htp3.hotel.service.exeption;

public class ServiceAddNewRoomException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ServiceAddNewRoomException(String message) {
		super(message);
	}

	public ServiceAddNewRoomException(String message, Exception e) {
		super(message, e);
	}

}
