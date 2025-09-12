# Discord-Social-SDK4J

Discord-Social-SDK4J is a project that aims to make easy-to-use bindings for Discord Social SDK.

<b><a href="https://discord.gg/hEqwGQtWDs">Discord</a></b> 

## Examples

#### Java port of [Getting Started with C++ and the Discord Social SDK](https://discord.com/developers/docs/discord-social-sdk/getting-started/using-c++)
```java
import dev.jab125.discordsocialsdk.api.DiscordNatives;
import dev.jab125.discordsocialsdk.api.discord.Activity;
import dev.jab125.discordsocialsdk.api.discord.AuthorizationArgs;
import dev.jab125.discordsocialsdk.api.discord.AuthorizationCodeVerifier;
import dev.jab125.discordsocialsdk.api.discord.Client;

import java.util.concurrent.atomic.AtomicBoolean;

import static dev.jab125.discordsocialsdk.api.discord.root.runCallbacks;

// Replace with your Discord Application ID
public static final long APPLICATION_ID = 1349146942634065960L;
public static final AtomicBoolean running = new AtomicBoolean(true);

void main() throws InterruptedException {
    try {
        DiscordNatives.loadNatives();
    } catch (Throwable e) {
        throw new Error("Failed to initialize natives!", e);
    }

    System.out.println("🚀 Initializing Discord SDK...");

    // Create our Discord Client
    Client client = new Client();

    // Set up logging callback
    client.addLogCallback((message, severity) -> {
        System.out.println("[" + severity + "] " + message);
    }, Client.LoggingSeverity.INFO);

    // Set up status callback to monitor client connection
    client.setStatusChangedCallback((status, error, errorDetail) -> {
        System.out.println("🔄 Status changed: " + status);

        if (status == Client.Status.READY) {
            System.out.println("✅ Client is ready! You can now call SDK functions.");

            // Access initial relationships data
            System.out.println("👥 Friends Count: " + client.getRelationships().size());

            // Configure rich presence details
            Activity activity = new Activity();
            activity.setType(Activity.ActivityTypes.PLAYING);
            activity.setState("In Competitive Match");
            activity.setDetails("Rank: Diamond II");

            // Update rich presence
            client.updateRichPresence(activity, result -> {
                if (result.successful()) {
                    System.out.println("🎮 Rich Presence updated successfully!");
                } else {
                    System.err.println("❌ Rich Presence update failed");
                }
            });
        } else if (error != Client.Error.NONE) {
            System.err.println("❌ Connection Error: " + error + " - Details: " + errorDetail);
        }
    });

    // Generate OAuth2 code verifier for authentication
    AuthorizationCodeVerifier codeVerifier = client.createAuthorizationCodeVerifier();

    AuthorizationArgs args = new AuthorizationArgs();
    args.setClientId(APPLICATION_ID);
    args.setScopes(client.getDefaultPresenceScopes());
    args.setCodeChallenge(codeVerifier.challenge());

    // Begin authentication process
    client.authorize(args, (result, code, redirectUri) -> {
        if (!result.successful()) {
            System.err.println("❌ Authentication Error: " + result.error());
        } else {
            System.out.println("✅ Authorization successful! Getting access token...");

            // Exchange auth code for access token
            client.getToken(APPLICATION_ID, code, codeVerifier.verifier(), redirectUri,
                    (_, accessToken, _, _, _, _) -> {
                        System.out.println("🔓 Access token received! Establishing connection...");
                        // Next Step: Update the token and connect
                        client.updateToken(Client.AuthorizationTokenType.BEARER, accessToken, clientResult -> {
                            if(clientResult.successful()) {
                                System.out.println("🔑 Token updated, connecting to Discord...");
                                client.connect();
                            }
                        });
                    });
        }
    });

    // Keep application running to allow SDK to receive events and callbacks
    while (running.get()) {
        runCallbacks();
        Thread.sleep(10);
    }
}
```
## Licensing

Discord-Social-SDK4J is licensed under the GNU Lesser General Public License versions 3 or later.
