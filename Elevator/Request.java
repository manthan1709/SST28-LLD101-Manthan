public class Request {
 int sourceFloor;
 Integer destinationFloor;
 Direction direction;
 RequestType requestType;

 public Request(int sourceFloor, Integer destinationFloor, Direction direction, RequestType requestType) {
  this.sourceFloor = sourceFloor;
  this.destinationFloor = destinationFloor;
  this.direction = direction;
  this.requestType = requestType;
 }
}
