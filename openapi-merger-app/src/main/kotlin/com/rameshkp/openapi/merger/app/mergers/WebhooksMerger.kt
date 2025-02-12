package com.rameshkp.openapi.merger.app.mergers

import io.swagger.v3.oas.models.Paths

class WebhooksMerger: PathsMerger() {
    override fun get(): Paths {
        val webhook = Paths()
        map.forEach { (key, value) ->  webhook.addWebhooks(key, value)}
        return webhook
    }
}
