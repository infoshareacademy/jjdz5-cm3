package com.isa.cm3.delegations;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.isa.cm3.servlets.DelegationSearchServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IdTokenVerifierAndParser {

    private static final String GOOGLE_CLIENT_ID
            = "714386444263-rduec7llk6q3odjpqf6ong5tp4kqb4n1.apps.googleusercontent.com";

    private static final Logger LOG = LogManager.getLogger(DelegationSearchServlet.class);

    public static GoogleIdToken.Payload getPayload (String tokenString) throws Exception {
        JacksonFactory jacksonFactory = new JacksonFactory();
        GoogleIdTokenVerifier googleIdTokenVerifier =
                new GoogleIdTokenVerifier(new NetHttpTransport(), jacksonFactory);

        GoogleIdToken token = GoogleIdToken.parse(jacksonFactory, tokenString);

        if (googleIdTokenVerifier.verify(token)) {
            GoogleIdToken.Payload payload = token.getPayload();
            if (!GOOGLE_CLIENT_ID.equals(payload.getAudience())) {
                LOG.warn("IllegalArgumentException(\"Audience mismatch\")");
                throw new IllegalArgumentException("Audience mismatch");
            } else if (!GOOGLE_CLIENT_ID.equals(payload.getAuthorizedParty())) {
                LOG.warn("IllegalArgumentException(\"Client ID mismatch\")");
                throw new IllegalArgumentException("Client ID mismatch");
            }
            LOG.info("Zalogowano poprawnie");
            return payload;
        } else {
            LOG.warn("IllegalArgumentException(\"id token cannot be verified\")");
            throw new IllegalArgumentException("id token cannot be verified");
        }
    }
}