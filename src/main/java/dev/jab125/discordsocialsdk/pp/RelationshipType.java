package dev.jab125.discordsocialsdk.pp;

public enum RelationshipType {
    NONE,
    FRIEND,
    BLOCKED,
    PENDING_INCOMING,
    PENDING_OUTGOING,
    @Deprecated
    IMPLICIT,
    @Deprecated
    SUGGESTION
};