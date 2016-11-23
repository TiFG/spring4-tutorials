package com.bytebeats.spring4.extension.xml;

import com.bytebeats.spring4.extension.domain.RpcProtocolBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-11-23 11:50
 */
public class RpcProtocolBeanDefinitionParser extends AbstractBeanDefinitionParser {

    @Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {

        return parseComponet(element, parserContext);
    }

    private AbstractBeanDefinition parseComponet(Element element, ParserContext parserContext) {

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(RpcProtocolBean.class);

        String id = element.getAttribute("id");
        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }

        String name = element.getAttribute("name");
        builder.addPropertyValue("name", name);

        String port = element.getAttribute("port");
        if (StringUtils.hasText(port)) {
            builder.addPropertyValue("port", Integer.parseInt(port));
        }

        String host = element.getAttribute("host");
        if (StringUtils.hasText(host)) {
            builder.addPropertyValue("host", host);
        }
        return builder.getBeanDefinition();
    }

}
