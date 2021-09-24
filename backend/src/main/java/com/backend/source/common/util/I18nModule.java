package com.backend.source.common.util;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;

import com.backend.source.service.I18nService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class I18nModule extends SimpleModule {

	private static final long serialVersionUID = -3060605154361115753L;
	private final I18nService i18nService;
	
	@Override
	public void setupModule(SetupContext context) {

	}

	@RequiredArgsConstructor
	class InternationalizingBeanSerializerModifier extends BeanSerializerModifier {

		private final InternationalizedSerializer serializer;

		@Override
		public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
				List<BeanPropertyWriter> beanProperties) {

			for (BeanPropertyWriter writer : beanProperties) {
				if (writer.getAnnotation(JsonInternationalized.class) != null) {
					String dtoClassStr = beanDesc.getBeanClass().toString();
					serializer.setDtoClassName(dtoClassStr.substring(dtoClassStr.lastIndexOf(".")+1));
					writer.assignSerializer(serializer);
				}
			}

			return beanProperties;
		}
	}

	@RequiredArgsConstructor
	class InternationalizedSerializer extends ToStringSerializer {

		private static final long serialVersionUID = -2391442803792997283L;
		
		private final I18nService i18nResourcesService;
		
		@Getter
		@Setter
		public String DtoClassName;
		
		@Override
		public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {

			Locale currentLocale = LocaleContextHolder.getLocale();
			if(!StringUtils.isEmpty(DtoClassName)) {
			String translator = i18nService.getMessage(value.toString(), value.toString(),DtoClassName,currentLocale.toString());
			gen.writeString(translator);
			}
		}
	}
}
