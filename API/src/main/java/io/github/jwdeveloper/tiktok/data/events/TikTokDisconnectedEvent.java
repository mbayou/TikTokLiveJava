/*
 * Copyright (c) 2023-2024 jwdeveloper jacekwoln@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.jwdeveloper.tiktok.data.events;
import io.github.jwdeveloper.tiktok.annotations.EventMeta;
import io.github.jwdeveloper.tiktok.annotations.EventType;
import io.github.jwdeveloper.tiktok.data.events.common.TikTokLiveClientEvent;
import lombok.Getter;


@Getter
@EventMeta(eventType = EventType.Control)
public class TikTokDisconnectedEvent extends TikTokLiveClientEvent {
	public static int UNKNOWN_CLOSE_CODE = -1;

	/** Valid CloseFrame code or -1 for unknown */
	private final int code;
	private final String reason;

	public TikTokDisconnectedEvent(int code, String reason) {
		this.code = code;
		this.reason = reason.isBlank() ? "None" : reason;
	}

	public TikTokDisconnectedEvent(String reason) {
		this(UNKNOWN_CLOSE_CODE, reason);
	}

	public boolean isUnknownCloseCode() {
		return this.code == UNKNOWN_CLOSE_CODE;
	}
}