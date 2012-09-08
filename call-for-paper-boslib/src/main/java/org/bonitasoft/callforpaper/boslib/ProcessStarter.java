package org.bonitasoft.callforpaper.boslib;

import com.thoughtworks.xstream.XStream;
import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.jaxrs.client.WebClient;
import org.bonitasoft.callforpaper.boslib.dto.ProcessInstanceUUID;

import javax.security.auth.login.LoginException;
import java.util.HashMap;

public class ProcessStarter {
    public static final String SERVER_ADDRESS = "http://localhost:9090";
    public static final String START_PROCESS_URI = "/bonita-server-rest/API/runtimeAPI/instantiateProcessWithVariables/";
    public static final String OPTIONS_HEADER = "options";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String RESTUSER = "restuser";
    public static final String RESTPWD = "restbpm";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String ENCODING = "application/x-www-form-urlencoded";
    public static final String EMAIL_VARIABLE_NAME = "sender_email";
    public static final String PAPER_ID_VARIABLE_NAME = "paper_id";
    private String email;
    private String processVersion;
    private String processName;
    private String username;
    private Long id;


    public ProcessStarter(String username) throws LoginException {
        this.username = username;
    }

    public ProcessStarter setEmail(String email) {
        this.email = email;
        return this;
    }

    public ProcessStarter setId(Long id) {
        this.id = id;
        return this;
    }

    public ProcessStarter setProcessName(String processName) {
        this.processName = processName;
        return this;
    }

    public ProcessStarter setProcessVersion(String processVersion) {
        this.processVersion = processVersion;
        return this;
    }

    public String execute() {
        WebClient client = WebClient.create(SERVER_ADDRESS);
        client.path(START_PROCESS_URI + processName + "--" + processVersion);
        client.header(AUTHORIZATION_HEADER, buildBasicAuthentication());
        client.header(OPTIONS_HEADER, buildOptionsHeaders());
        client.header(CONTENT_TYPE_HEADER, ENCODING);

        ProcessInstanceUUID response = client.post(
                buildRequestBody(),
                ProcessInstanceUUID.class);


        return response.getValue();
    }

    private String buildOptionsHeaders() {
        return "user:" + username;
    }

    private String buildBasicAuthentication() {
        return "Basic " + Base64Utility.encode((RESTUSER + ":" + RESTPWD).getBytes());
    }

    private String buildRequestBody() {
        HashMap<String, Object> variables = new HashMap<String, Object>();
        variables.put(EMAIL_VARIABLE_NAME, email);
        variables.put(PAPER_ID_VARIABLE_NAME, id);
        XStream xStream = new XStream();

        return "variables="+xStream.toXML(variables);
    }
}
