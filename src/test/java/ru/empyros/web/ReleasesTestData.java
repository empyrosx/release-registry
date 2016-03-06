package ru.empyros.web;

import ru.empyros.model.Release;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ReleasesTestData {

    public static final int RELEASE1_ID = 100000;
    public static final Release RELEASE_161 = new Release(RELEASE1_ID
            , "Release_161", "https://cloud.empyros.ru/index.php/s/R1O4PmW8Z0xBToj", LocalDate.of(2016, 03, 03));
    public static final Release RELEASE_160 = new Release(RELEASE1_ID + 1
            , "Release_160", "https://cloud.empyros.ru/index.php/s/6sKfj3C8VPwmGZe", LocalDate.of(2016, 03, 03));
    public static final Release RELEASE_159 = new Release(RELEASE1_ID + 2
            , "Release_159", "https://cloud.empyros.ru/index.php/s/ZsurYVseCJwGKjh", LocalDate.of(2016, 03, 03));
    public static final Release RELEASE_158 = new Release(RELEASE1_ID + 3
            , "Release_158", "https://cloud.empyros.ru/index.php/s/MqvFhbsGSXOjSOo", LocalDate.of(2016, 03, 02));
    public static final Release RELEASE_157 = new Release(RELEASE1_ID + 4
            , "Release_157", "https://cloud.empyros.ru/index.php/s/PL3gZfjTi2MCIbM", LocalDate.of(2016, 03, 02));
    public static final Release RELEASE_156 = new Release(RELEASE1_ID + 5
            , "Release_156", "https://cloud.empyros.ru/index.php/s/MD1yXU0WaJRCU8M", LocalDate.of(2016, 02, 29));
    public static final Release RELEASE_155 = new Release(RELEASE1_ID + 6
            , "Release_155", "https://cloud.empyros.ru/index.php/s/PJKrYbd07N6enb3", LocalDate.of(2016, 02, 27));

    public static final List<Release> RELEASES = Arrays.asList(RELEASE_161, RELEASE_160, RELEASE_159
    , RELEASE_158, RELEASE_157, RELEASE_156, RELEASE_155);
}
