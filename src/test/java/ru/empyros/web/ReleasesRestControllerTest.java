package ru.empyros.web;

import java.util.List;
import javax.annotation.PostConstruct;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import ru.empyros.model.Release;
import ru.empyros.service.ReleasesService;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.empyros.releases.Profiles.HSQLDB;
import static ru.empyros.web.ReleasesTestData.RELEASE1_ID;
import static ru.empyros.web.ReleasesTestData.RELEASE_161;

@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-mvc.xml"
})
@WebAppConfiguration
@ActiveProfiles(HSQLDB)
@RunWith(SpringJUnit4ClassRunner.class)
public class ReleasesRestControllerTest {

    public static final String REST_URL = ReleasesRestController.REST_UPDATES_URL + '/';
    private static final CharacterEncodingFilter CHARACTER_ENCODING_FILTER;

    static {
        CHARACTER_ENCODING_FILTER = new CharacterEncodingFilter();
        CHARACTER_ENCODING_FILTER.setEncoding("UTF-8");
        CHARACTER_ENCODING_FILTER.setForceEncoding(true);
    }

    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Autowired
    private ReleasesService service;

    private static Release jsonConverter(String json) {
        return JsonUtil.readValue(json, Release.class);
    }

    private static List<Release> jsonListConverter(String json) {
        return JsonUtil.readValues(json, Release.class);
    }

    @PostConstruct
    void postConstruct() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilter(CHARACTER_ENCODING_FILTER)
                .build();
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(getListMatcher(ReleasesTestData.RELEASES)));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + "100000").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(getMatcher(RELEASE_161)));
    }

    @Test
    public void testGetUpdate() throws Exception {
        Release updated = new Release(RELEASE1_ID, RELEASE_161.getName()
                , "NEW_IOUOIUEW", RELEASE_161.getReleased());
        mockMvc.perform(put(REST_URL).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isOk());

        assertEquals(updated, service.get(RELEASE1_ID));
    }

    private Matcher<String> getMatcher(Release expected) {
        return Matchers.matcher(expected
                , ReleasesRestControllerTest::jsonConverter, Release::toString);
    }

    private Matcher<String> getListMatcher(List<Release> expected) {
        return Matchers.listMatcher(expected
                , ReleasesRestControllerTest::jsonListConverter, Release::toString);
    }
}