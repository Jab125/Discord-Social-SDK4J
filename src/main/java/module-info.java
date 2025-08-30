@SuppressWarnings("JavaModuleNaming")
module dev.jab125.discordsocialsdk {
	requires static org.jetbrains.annotations;
	requires java.base;

	exports dev.jab125.discordsocialsdk.api;
	exports dev.jab125.discordsocialsdk.api.discord;

	opens dev.jab125.discordsocialsdk.impl;
	opens dev.jab125.discordsocialsdk.impl.cdiscord;
}