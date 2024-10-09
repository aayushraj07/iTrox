// package com.example.iTrox.service.impl;
//
// import com.example.iTrox.entity.Advertisement;
// import com.example.iTrox.repository.AdvertisementRepository;
// import com.example.iTrox.service.AdvertisementService;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.modelmapper.ModelMapper;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import java.util.List;
//
// import static org.junit.jupiter.api.Assertions.*;
//
// @SpringBootTest
// class AdvertisementServiceImplTest {
//
//    @Mock
//    private AdvertisementRepository repository;
//
//    @Mock
//    private ModelMapper mapper;
//
//    @InjectMocks
//    AdvertisementService advertisementService = new AdvertisementServiceImpl();
//
//    @DisplayName("Get Advertisement - Success Sceario")
//    @Test
//    void test_When_Order_Success() {
////        Mocking - internal different calls will be mocked
//        List<Advertisement> advertisements = getAdvertisments();
//        Mockito.when(repository.findAll())
//                .thenReturn(List<Advertisement>)
////        Actual - actual method call
//        advertisementService.getAll();
////        Verification - internal calls
////        Assert - will check if we got the result which we wanted
//    }
//
//    private List<Advertisement> getAdvertisments(){
//        return Advertisement.builder().
//    }
//
//    @Test
//    public void testCreate(){
//
//    }
//
// }
