package com.rameshkp.openapi.merger.app.mergers

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.mockk
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.PathItem

class WebhooksMergerTest : BehaviorSpec({
    given("2 webhooks objects to merge") {
        `when`("merged using webhooks merger") {
            then("the result should contain both webhooks") {
                val webhook1 = OpenAPI()
                val webhook2 = OpenAPI()

                val pathItem1 = PathItem()
                pathItem1.get = mockk()
                val pathItem2 = PathItem()
                pathItem2.get = mockk()

                webhook1.addWebhooks("newPet", pathItem1)
                webhook1.addWebhooks("removePet", pathItem2)

                val webhookMerger = WebhooksMerger()
                webhookMerger.merge(webhook1.webhooks)
                webhookMerger.merge(webhook2.webhooks)

                val webhooks = webhookMerger.get()
                webhooks.size shouldBe 2
                webhooks["newPet"] shouldNotBe null
                webhooks["newPet"]?.get shouldNotBe null
                webhooks["removePet"] shouldNotBe null
                webhooks["removePet"]?.get shouldNotBe null
            }
        }
    }
})
