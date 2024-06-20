package coliving.data.dto;

public record ReserveRoomCommand(String roomId, String startDate, String endDate, Integer guestNumber){}
