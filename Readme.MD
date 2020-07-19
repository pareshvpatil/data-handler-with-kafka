Services Planned:
1. Data Collector
	- POST API to receive data from devices (DONE)

2. Data Consumer
	- Consumer service to get data from kafka (TODO)
	- Database integration to push data in DB (table relationships, repositories done)

3. Data Provider
	- Websocket to expose db entries for required devices

* Design Considerations
	- Detaching API response from actual processing to push message in kafka (allows high throughput)
	- Introducing alternative storage to hold messages that were not sent to kafka
	- Partitioning on kafka topics to allow for parallel consumption