# camunda-booking-service
B1: run neo4j desktop app, add mới một local DBMS, setting password 
B2: lấy password đã tạo sửa lại ở file: "src\main\resources\application.properties" line: spring.neo4j.authentication.password='thay ở đây'

Luồng chạy:
  -Tạo ra 2 node Booking và RoomMaster
  -RoomMaster sẽ được tạo mới theo tên của RoomType.
