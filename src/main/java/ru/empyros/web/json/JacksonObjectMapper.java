package ru.empyros.web.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

import java.io.IOException;
import java.time.LocalDate;

public class JacksonObjectMapper extends ObjectMapper {

    private static final ObjectMapper MAPPER = new JacksonObjectMapper();

    public static ObjectMapper getMapper() {
        return MAPPER;
    }


    private JacksonObjectMapper() {
        registerModule(new Hibernate4Module());

        SimpleModule customModule = new SimpleModule("customModule", new Version(1, 0, 0, null));
        customModule.addSerializer(new UserSettingSerializer());
        customModule.addDeserializer(LocalDate.class, new UserSettingDeserializer());
        registerModule(customModule);

        setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static class UserSettingSerializer extends JsonSerializer<LocalDate> {
        @Override
        public void serialize(LocalDate ldt, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString(ldt.toString());
        }

        @Override
        public Class<LocalDate> handledType() {
            return LocalDate.class;
        }
    }

    public static class UserSettingDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
            return LocalDate.parse(jp.getText());
        }

        @Override
        public Class<LocalDate> handledType() {
            return LocalDate.class;
        }
    }
}
