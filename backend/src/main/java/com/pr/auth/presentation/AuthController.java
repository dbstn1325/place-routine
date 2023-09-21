package com.pr.auth.presentation;

import com.pr.auth.application.OAuthUri;
import com.pr.auth.dto.response.OAuthUriResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final OAuthUri oAuthUri;

    @GetMapping("/{oauthProvider}/oauth-uri")
    public ResponseEntity<OAuthUriResponse> generateLink(@PathVariable final String oauthProvider,
                                                         @RequestParam final String redirectUri) {
        OAuthUriResponse oAuthUriResponse = new OAuthUriResponse(oAuthUri.generate(redirectUri));
        return ResponseEntity.ok(oAuthUriResponse);
    }

    @PostMapping("/{oauthProvider}/token")
    public ResponseEntity.BodyBuilder generateAccessAndRefreshToken(
            @PathVariable final String oauthProvider) {
        return ResponseEntity.ok();
    }
}
