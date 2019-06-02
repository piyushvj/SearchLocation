# SearchLocation

This application calls two third part apis, and prepare new custom response.

api1.url=http://services.groupkt.com/state/get/IND/UP
api2.url=http://services.groupkt.com/state/search/IND?text=UP


REQUEST URL : http://localhost:9090/search/location?state=UP

RESPONSE : 

{
    "message": "State found matching code [UP]. And there are total Total [1] records found."
}