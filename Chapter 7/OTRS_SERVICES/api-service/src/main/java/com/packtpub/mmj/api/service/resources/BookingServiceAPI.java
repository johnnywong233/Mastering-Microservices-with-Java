package com.packtpub.mmj.api.service.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.packtpub.mmj.common.ServiceHelper;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/v1/bookings/")
public class BookingServiceAPI {

    private static final Logger LOG = LoggerFactory.getLogger(BookingServiceAPI.class);

    @Autowired
    ServiceHelper serviceHelper;
    @Autowired
    DiscoveryClient client;
    //@Qualifier("userInfoRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Add booking with the specified information.
     *
     * @param booking
     * @return A non-null booking.
     */
    @RequestMapping(method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "defaultAddBooking")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        LOG.info(String.format("api-service addBooking() invoked: POST /v1/booking/"));
        String url = "http://booking-service/v1/booking/";
        LOG.debug("addBooking from URL: {}", url);
        ResponseEntity<Booking> result = restTemplate.postForEntity(url, booking, Booking.class);
        LOG.info("addBooking http-status: {}", result.getStatusCode());
        LOG.debug("addBooking body: {}", result.getBody());

        return serviceHelper.createResponse(result.getBody(), result.getStatusCode());
    }

    /**
     * Fallback method
     *
     * @param booking
     * @return
     */
    public ResponseEntity<Booking> defaultAddBooking(Booking booking) {
        LOG.warn("Fallback method for booking-service is being used.");
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
}

@Data
class Booking {

    private String name;
    private String id;
    private String restaurantId;
    private String userId;
    private LocalDate date;

    private LocalTime time;
    private String tableId;
}